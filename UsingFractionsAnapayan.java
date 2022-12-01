class UsingFractionsAnapayan
{
   public static void main(String[] args)
   {
      Fraction f = new Fraction(3,4);
      f.reduce();
      Fraction g = new Fraction(1,-2);
      Fraction z = new Fraction(4,5);
      Fraction y = new Fraction(2,3);
      System.out.println("Sum: "+Fraction.sum(f,z));
      
      System.out.println(f+" x "+g+" x "+z+" = "+Fraction.times(f,g,z));
      System.out.println(f+" x "+g+" x "+z+" x "+y+" = "+Fraction.times(f,g,z,y));
      Fraction k = Fraction.times(f,g);
      System.out.println(k);
      
      Fraction j = new Fraction (4);
      Fraction h = f.times(g); // k = i+1
      Fraction i = new Fraction(f); // clone Fraction f
      f.timesEquals(g);        // i++;
      System.out.println(f.size());
   }
}

class Fraction
{
   // fields
   private int num, den; 
   
   // constructor
   public Fraction(int num, int den) // these num and den are local
   {
      this.num = num; //this indicates you want the field/objects variable
      this.den = den;
      
      if (this.den < 0)
      {
         this.den*=-1;
         this.num*=-1;
      }
      System.out.println("New fraction: "+num+"/"+den+" at:"+this);
   }
   
   // constructor (overload the constructor method)
   public Fraction()
   {
      this(0,1);
   }
      
   // constructor - a whole number as input to converted to a fraction
   public Fraction(int number) 
   {
      this(number, 1);
   }
   
   //constructor to clone a Fraction
   public Fraction(Fraction clone)
   {
      this(clone.num, clone.den);
   }
   
   public String toString()
   {
      return num+"/"+den;
   }
   
   // call: int n = f.getNumerator();
   // Accessor method to get the numerator
   public int getNumerator()
   {
      return this.num;
   }
   
   // Accessor method to get the numerator
   public int getDenominator()
   {
      return this.den;
   }
   
   // call: f.setNumerator(3);
   // Mutator method to change the numerator
   public void setNumerator(int value)
   {
      this.num = value;
   }
   
   // Mutator method for denominator
   public void setDenominator(int value)
   {
      this.den = value;
   }
   
   // instance method size
   public double size ()
   {
      return (double)num/(double)den;
   }
   
   // instance method timesEqual
   public void timesEquals(Fraction other)
   {
      this.num = this.num*other.num;
      this.den = this.den*other.den;
      return;
   }
   
   // instance method larger
   public Fraction larger(Fraction other)
   {
      if (other.size() > this.size())
         return other;
      return this;
   }
   
   // instance method times 
   public Fraction times(Fraction other)
   {
      Fraction result = new Fraction();
      result.num = this.num*other.num;
      result.den = this.den*other.den;
      return result;
   }
   
   // class method times to overlaod the times method above
   public static Fraction times(Fraction first, Fraction second)
   {
      Fraction result = new Fraction();
      result.num = first.num*second.num;
      result.den = first.den*second.den;
      return result;
   }
   
   public static Fraction times(Fraction first, Fraction second, Fraction third)
   {
      Fraction result = new Fraction();
      result = times(times(first, second), third);
      return result;
   }
   
   public static Fraction times(Fraction first, Fraction second, Fraction third, Fraction fourth)
   {
      Fraction result = new Fraction();
      result = times(times(first, second, third), fourth);
      return result;
   }
   
   public void reduce()
   {
      if (den>num)
      {
         for(int i=num; i>=0; i--)
         {
            if (num%i==0 && den%i==0)
            {
               num/=i;
               den/=i;
               break;
            }
         }
      }
      else if (num>den)
      {
         for(int i=den; i>0; i--)
         {
            if (num%i==0 && den%i==0)
            {
               num/=i;
               den/=i;
               break;
            }
         }
      }
      System.out.println(num+"/"+den);
      }
      
      // class method called sum
      // do not alter the two fractions being added
      // return back the sum as a reduced fraction
      public static Fraction sum(Fraction f, Fraction g)
      {
         Fraction result = new Fraction();
         result.num = (f.num*g.den)+(g.num*f.den);
         result.den = f.den*g.den;
         result.reduce();
         return result;
      }
      
      // instance method plusEquals
      // this method should add the second fraction INTO the implicit one
      public void sum(Fraction f)
      {
         this.num = (this.num*f.den)+(this.den*f.num);
         this.den*=f.den;
         this.reduce();
      }
}
