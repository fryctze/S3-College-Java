package Class.KBs.KB2.praktikum;

public class ServiceLogNodes {
    Service data;
    ServiceLogNodes link;

    public ServiceLogNodes(Service service){
        data = service;
        link = null;
    }

    public Service getData(){
        return data;
    }
}
