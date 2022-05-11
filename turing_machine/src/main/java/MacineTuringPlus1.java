/**
Класс эмулирует машину Тьюринга
Выполняется программа: прибавление 1 к числу, записанному в 3-ном исчислении
*/
public class MacineTuringPlus1 {
    A current;
    int state;

    C[][] programm = {
            {new C('\0','L',2), new C('0','R',1),  new C('1','R',1),  new C('2','R',1)},
            { new C('1','N',0), new C('1','N',0), new C('2','N',0), new C('0','L',2)}
    };


    private void makeTape(String inputData) { // 20011201
        System.out.println(inputData);
        //преобразуем введённую строку в массив символов
        char[] a = (inputData+'\0').toCharArray();//  '2','0','0','1','1','2','0','1','\0'
        // зафиксируем позицию "считывающей головки"
        // на этапе создания "ленты" она будет стоять на первом элементе
        current = new A();
        current.value = a[0]; //2
        current.prev = null;
        // создадим "ленту" в виде двусвязного списка
        for (int i = 1; i < a.length; i++) {
            A top = current;
            while (top.next != null) {
                top = top.next;
            }
            A last = new A();
            top.next = last;
            last.prev = top;
            last.value = a[i];
        }
    }

    private String startMachine() {
        String result="";
        state = 1;
        while (state != 0) { // 0 ~ !
            int i = (current.value != '\0' ? Integer.parseInt(current.value+"") + 1:0);
            C c=programm[state-1][i];
            state = c.state;
            current.value = c.newValue;
            System.out.println(current.value+" "+c.direction+" "+c.state);
            if (c.direction=='R') {
                if (current.next==null){
                    //добавим элемент справа с пустым значением (иммитируем бесконечную справа ленту)
                    A n =new A();A last = new A();
                    n.value = '\0';
                    n.prev = current;
                    current.next = n;
                }
                current=current.next;
            }
            else if(c.direction=='L') {
                if (current.prev==null){
                    //добавим элемент слева с пустым значением (иммитируем бесконечную слева ленту)
                    A n =new A();
                    n.value = '\0';
                    n.next = current;
                    current.prev = n;
                }
                current=current.prev;
            }
            else if(c.direction=='N'){}
        }

        //найдем начало "ленты"
        while (current.prev!=null) current=current.prev;
        //от начала пойдем к концу, считывая с ленты символы и записывая их в результат
        while (current.next!=null) {
            result += current.value;
            current = current.next;
        }
        return result;
    }

    public static void main(String[] args) {
        MacineTuringPlus1 mt = new MacineTuringPlus1();

        mt.makeTape("222");//1000


        System.out.println(mt.startMachine());
    }


    // Tape element
    class A {
        char value;
        A next; //next Tape element
        A prev; //prev Tape element
    }

    class C {
        char newValue;
        char direction;
        int state;

        // конструктор для удобства инициализации
        public C(char newValue, char direction, int state) {
            this.newValue = newValue;
            this.direction = direction;
            this.state = state;
        }
    }
}