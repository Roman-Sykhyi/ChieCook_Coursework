package chiefcook.chiecook_coursework.builders;

import chiefcook.chiecook_coursework.models.Salad;

public abstract class SaladBuilder {
    protected Salad salad;

    public abstract void createNewSalad();

    public Salad getSalad() {
        return salad;
    }
}