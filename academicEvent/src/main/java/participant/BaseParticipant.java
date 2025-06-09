package participant;

import java.util.HashSet;

public abstract class BaseParticipant {
    /* atributos padrão dos participantes */
    protected String name;
    protected int age;
    protected String email;
    protected int idParticipant;

    /* Collection para armazenar todos os participantes sem distinção  */
    protected static HashSet<BaseParticipant> listParticipant = new HashSet<>();

    public BaseParticipant(String name, int age, String email, int idParticipant) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.idParticipant = idParticipant;
        listParticipant.add(this); /* adicionar automaticamente ao criar */
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(int idParticipant) {
        this.idParticipant = idParticipant;
    }

    public static HashSet<BaseParticipant> getListParticipant() {
        return listParticipant;
    }

    public static void setListParticipant(HashSet<BaseParticipant> listParticipant) {
        BaseParticipant.listParticipant = listParticipant;
    }
}
