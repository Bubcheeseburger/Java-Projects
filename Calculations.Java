// This project expands on the python version I created with getters and setters and a toString
// and the new addition of the swap method and double and float division



    // Set up basic attributes for mem1, mem2, op
    public Calculations(){
        mem1 = 0;
        mem2 = 0;
        op = " ";
    }

    // Takes in values for mem1, mem2, and op, and it assigns the values
    public Calculations(int op1, int op2, String newOp){
        setMem1(op1);
        setMem2(op2);
        if (newOp.equals("+") || newOp.equals("-") || newOp.equals("*") || newOp.equals("/") || newOp.equals("^")) {
            setOp(newOp);
        }else {
            op = " ";
        }
    }

    // Returns mem1 value
    public int getMem1() {
        return mem1;
    }

   // Changes mem1 value
    public void setMem1(int op1) {
        this.mem1 = op1;
    }

    // Returns mem2 value
    public int getMem2() {
        return mem2;
    }

    // Changes mem2 value
    public void setMem2(int op2) {
        this.mem2 = op2;
    }

    // Returns op value
    public String getOp() {
        return op;
    }

    // Changes op value
    public void setOp(String newOp) {
        if (newOp.equals("+") || newOp.equals("-") || newOp.equals("*") || newOp.equals("/") || newOp.equals("^")){
            this.op = newOp;
        }
    }

    // Turns all the values into a string expression
    public String toString(){
        return this.mem1 + " " + this.op + " " + this.mem2;
    }

    // Performs on operation with the numbers and given operation
    public int perform(){
        if (op.equals("+")){
            this.mem2 = mem1 + mem2;
        }
        else if (op.equals("-")){
            this.mem2 = mem1 - mem2;
        }
        else if (op.equals("*")){
            this.mem2 = mem1 * mem2;
        }
        else if (op.equals("/") && mem2 != 0){
            this.mem2 = mem1 / mem2;
        }
        else if (op.equals("^")){
            this.mem2 = (int) Math.pow(mem1,mem2);
        }
        return mem2;
    }


    // Performs decimal division based on inputted numbers
    public double performDiv(){
        double value = 0.0;
        if (mem2 != 0){
            value = (double) mem1 / mem2;
        }
        return value;
    }

    // Swaps the place of mem1 and mem2 values
    public void swap(){
        int tempValue;
        tempValue = mem1;
        this.mem1 = mem2;
        this.mem2 = tempValue;
    }

    public static void main(String[] args){
        Calculations c = new Calculations();
        Calculations c2 = new Calculations(1,2,"+");

        System.out.println(c);
        System.out.println(c2);

        c.setMem1(5);
        c.setMem2(7);
        c.setOp("+");
        System.out.println(c);
        System.out.println(c.perform());

        c.swap();
        c.setOp("-");
        System.out.println(c);
        System.out.println(c.perform());

        c.setOp("*");
        System.out.println(c.perform());

        c.swap();
        c.setOp("/");
        System.out.println(c);
        System.out.println(c.perform());

        System.out.println(c);
        System.out.println("mem2 is " + c.getMem2());

        System.out.println(c.performDiv());

        c.setMem2(0);
        System.out.println(c.perform());
        System.out.println(c);

        Calculations c3 = new Calculations(3,2,"+");
        System.out.println(c3);
        c3.setOp("9");
        System.out.println(c3);
    }
}
