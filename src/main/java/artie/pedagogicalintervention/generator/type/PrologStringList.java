package artie.pedagogicalintervention.generator.type;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Getter
@Setter
@Builder
public class PrologStringList {
    private List<String> list = new ArrayList<>();

    public void add(String value){
        list.add(value);
    }

    public void addUnique(String value){
        if(!list.contains(value)){
            list.add(value);
        }
    }

    public String toString(){
        AtomicReference<String> values = new AtomicReference<>("");
        list.forEach(v -> {
            values.set(values + v + ", ");
        });
        return values.get().substring(0, values.get().length() - 2);
    }
}
