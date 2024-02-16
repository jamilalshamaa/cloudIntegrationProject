package test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptExecutor {

    private final ScriptEngine engine;

    public JavaScriptExecutor() {
        engine = new ScriptEngineManager().getEngineByName("nashorn");
    }

    public Object execute(String script) {
        try {
            // A simple JavaScript code example
            return engine.eval(script);
        } catch (ScriptException e) {
            throw new RuntimeException("Error executing JavaScript", e);
        }
    }
}
