package todo.repositorii;

import todo.model.Cotegori;

import java.util.Map;

public class DbTodo {
    private Map <Integer, Cotegori> cotegoriMap;

    public DbTodo(Map<Integer, Cotegori> cotegoriMap) {
        this.cotegoriMap = cotegoriMap;
    }

    public Map<Integer, Cotegori> getCotegoriMap() {
        return cotegoriMap;
    }

    public void setCotegoriMap(Map<Integer, Cotegori> cotegoriMap) {
        this.cotegoriMap = cotegoriMap;
    }
}
