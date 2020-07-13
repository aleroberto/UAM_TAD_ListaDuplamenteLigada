class No {
    private int dado;
    private No proximo;
    private No anterior;

    public No(int dado) {
        this.dado = dado;
        anterior = proximo = null;
    }

    public int getDado() {
        return dado;
    }

    public No getProximo() {
        return this.proximo;
    }

    public No getAnterior() {
        return this.anterior;
    }

    public void setProximo(No proximoNo) {
        this.proximo = proximoNo;
    }

    public void setAnterior(No anteriorNo) {
        this.anterior = anteriorNo;
    }

}

/**
* @methods 
**/
public class ListaDuplamenteLigada {
    No first;
    No last;

    public ListaDuplamenteLigada() {
        first = last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }


    //Inserindo no inicio
    public void insertFront(int dado) {
        No novoNo = new No(dado);
        if(isEmpty()) {
            first = last = novoNo;
        } else {
            novoNo.setProximo(first);
            first.setAnterior(novoNo);
            first = novoNo;
        }
    }


    //Inserindo no final
    public void insertBack(int dado) {
        No novoNo = new No(dado);
        if(isEmpty()) {
            first = last = novoNo;
        } else {
            last.setProximo(novoNo);
            novoNo.setAnterior(last);
            last = novoNo;
        }
    }

    //deletando item
    public No deleteKey(int value) {
        No auxiliar = first;
        //lista vazia
        if(auxiliar == null) {
            return null;
        }
        //localizando o valor
        while(auxiliar.getDado() != value) {
            auxiliar = auxiliar.getProximo();
            if(auxiliar.getProximo() == null) {
                return null;
            }

            //removendo-o
            if(auxiliar == first) {
                first = auxiliar.getProximo();
            } else {
                auxiliar.getAnterior().setProximo(auxiliar.getProximo());
            }

            if(auxiliar == last) {
                last = auxiliar.getAnterior();
            } else {
                auxiliar.getProximo().setAnterior(auxiliar.getAnterior());
            }
        }
        return auxiliar;
    }


    //Deletando o ultimo
    public No deleteLast() {
        No auxiliar = last;
        if(first == null) {
            return null;
        }

        if(first.getProximo() == null) {
            first = last = null;
        } else {
            last.getAnterior().setProximo(null);
        }

        return auxiliar;
    }

    //deletando o primeiro
    public No deleteFirst() {
        No auxiliar = first;
        if (first == null) {
            return null;
        }
        if(first.getProximo() == null) {
            last = first = null;
        } else {
            // first.getProximo().setProximo(null);
            first = first.getProximo();
        }
        return auxiliar;
    }


    //Exibindo para frente
    public void displayForward() {
        System.out.println("lista:");
        No auxiliar = first;
        int contador = 0;
        while(auxiliar != null) {
            System.out.println(auxiliar.getDado() + " ");
            auxiliar =  auxiliar.getProximo();
            contador++;
        }
        System.out.println("Esta lista contem: " + contador + " item(ns)");
    }

    //Inserindo no meio da lista
    public boolean insertAfter(int key, int value) {
        No auxiliar = first;
        if(auxiliar == null) {
            return false;
        }

        while (auxiliar.getDado() !=  value) {
            auxiliar = auxiliar.getProximo();
            if(auxiliar == null) {
                return false;
            }
        }

        No novoNo = new No(value);
        if(auxiliar == last) {
            novoNo.setProximo(null);
            last = novoNo;
        } else {
            novoNo.setProximo(auxiliar.getProximo());
            auxiliar.getProximo().setAnterior(novoNo);
        }
        novoNo.setAnterior(auxiliar);
        auxiliar.setProximo(novoNo);
        return true;
    }

    public static void main(String [] argsa) {
        ListaDuplamenteLigada li = new  ListaDuplamenteLigada();
        li.insertBack(10);
        for(int i = 0; i < 5; i++) {
            li.insertBack(i);
        }

        li.insertBack(20);
        //	li.deleteFirst();

        //    li.deleteLast();
        li.displayForward();
        li.deleteKey(20);
              li.displayForward();

    }



}