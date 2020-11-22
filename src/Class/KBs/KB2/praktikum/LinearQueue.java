package Class.KBs.KB2.praktikum;

public class LinearQueue {
    int front, rear;
    int size;
    OnGoingService[] data;
    int maxSize;

    public LinearQueue(int maxSize) {
        this.maxSize = maxSize;
        data = new OnGoingService[this.maxSize];
        size = 0;
        front = rear = -1;
    }

    public void enqueue(OnGoingService data){
        if (size < maxSize) {
            if (front == -1){
                front = rear = 0;
            } else {
                for (int i = rear; i >= 0; i--) {
                    this.data[i+1] = this.data[i];
                }
                rear +=1;
            }
            this.data[0] = data;
            size++;
        } else{
            System.out.println("Antrian untuk "+data.getUserId()+" juga penuh! Jadi silahkan pulang");
        }
    }

    public OnGoingService dequeue(){
        OnGoingService output = null;
        if (front == -1) {
            System.out.printf("System Error!! Tidak ditemukan orang yang sedang mengantri");
        } else {
            output = data[0];
            for (int i = 0; i < rear; i++) { // replace
                data[i] = data[i+1];
            }
            if (rear < size)
                data[rear] = null;
            rear--;
            size--;
        }
        return output;
    }

    public void dequeueUser(String userId){
        if (front == -1) {
            System.out.printf("\nQueue is empty\n");
        } else {
            int found = -1;
            for (int i = 0; i < size; i++) {
                if (data[i].getUserId().equals(userId)){
                    found = i;
                    break;
                }
            }

            if (found != -1){
                if (front <= found && found <= rear){
                    System.out.println(data[found].getUserId()+" Telah menyerah mengantri dan ia pun pulang");
                    for (int i = found; i < rear; i++) {
                        data[i] = data[i+1];
                    }

                    if (rear < size)
                        data[rear] = null;
                    rear--;
                    size--;
                }
            } else {
                System.out.println("Dequeue User gagal: Userid tidak ditemukan");
            }
        }
    }
}
