/**
 * A class to represent temperature (with a value and scale).
 *
 * CS 120
 * Spring 2019
 * Midterm Project 1
 */

	public class Temperature
	{
		protected double temp;
		protected  Scale scale;
		// define the attributes
		
		/** Initializes a temperature object with given value in Celsius
		 *  <p>
		 *  If the initial temperature is less than -273.15C then the temperature
		 *  object will be initialized with -273.15C.
	   *
		 * @param temp is the initial temperature in Celsius.
		 */		

		public Temperature(double temp)
		{
			//by default the scale is CELCIUS 
			this.scale = scale.CELSIUS;
			if (temp <= -273.15)
				this.temp = -273.15;
			else
				this.temp = temp;

		}
		
		/** Initializes a temperature object with given value using the specified scale
		   * <p>
			 * If the temperature is lower than absolute zero, in the given scale,
			 * then set the temperature to absolute zero (in that scale).
		   * <p>
		 	 * Usage: new Temperature(12.3, Scale.KELVIN)
			 *
			 * @param temp is the initial temperature in the scale provided in
		   *        the second argument.
			 * @param scale is the scale of initial temperature and must be a constant
			 *        defined in the Scale enum type.
			 */

		public Temperature(double temp, Scale scale)
		{
			// to complete
			this.scale  = scale;

			switch(scale)
			{
			case CELSIUS:
				if (temp <= -273.15)
					this.temp = -273.15;
				else
					this.temp = temp;
				break;

			case FAHRENHEIT: 
				if (temp<= -459.67)
					this.temp = -459.67;
				else
					this.temp = temp;
				break;

			case KELVIN:
				if (temp < 0)
					this.temp = 0;
				else
					this.temp = temp;

			}
		}
		/** Initializes a new temperature object that is a copy of the
		   *  temperature object parameter.
		   *
		   * That is, it makes a new object that is a copy of the input object.
		   *
			 * @param temp is a non-null temperature object
			 */
		public Temperature(Temperature temp){
			// to complete
			this.scale = temp.scale;
			this.temp = temp.temp;
		}
	
			
			/** getter for the scale
			 * <p>
			 * The output of this getter method must always be the first letter of one
			 * of the names in the Scales enum class. It must be the upper case letter.
			 * <p>
			 * Example: t = new Temperature(12.3, Scale.KELVIN);
			 *          t.getScale() will then output 'K'
			 *
			 * @return the first letter (in upper case) of the string representation of the
			 *         current scale of this object.
			 */
		public char getScale(){

			char cscale = 'C';

			switch (this.scale)
			{
			case CELSIUS:
				cscale = 'C';
				break;

			case FAHRENHEIT:
				cscale = 'F';
				break;

			case KELVIN:
				cscale = 'K';
				break;
			}
			return cscale;
		}
		/** getter for the temperature
		 *
		 * @return the temperature of the object using the current scale
		 */
		
		public double getTemp(){
			return temp; 
		}
		 /** setter for scale
		 *
		 * @param scale is the new scale of the temperature and must be
		 *        a constant from the Scale enum type. The next time you
		 *        call getTemp(), the temperature will be output in this scale.
	   * @return a reference to this object.
		 */
		public Temperature setScale(Scale scale){

			double t;
			switch(scale)
			{
			case CELSIUS:
				switch (this.scale)
				{
				case CELSIUS:
					break; //no changes
				case FAHRENHEIT: //change from celcius to faranheit
					t = (this.temp * 9/5)+ 32;
					if (t < -237.15 ) t = -237.15;
					this.temp = t;
					break;
				case KELVIN: //change from celicius de kelvin
					t = (this.temp + 273.15);
					if (t < -237.15 ) t = -237.15;
					this.temp = t;
					break;	
				}

			case FAHRENHEIT: 
				switch (this.scale)
				{
				case CELSIUS:
					t = (this.temp - 32)* 5/9;
					this.temp = t;
					break;
				case FAHRENHEIT:
					break;

				case KELVIN: 
					t = (this.temp - 32)* 5/9 +273.15;
					if (t < -237.15 ) t = -237.15;
					this.temp = t;
					break;	
				}


			case KELVIN:
				switch (this.scale)
				{
				case CELSIUS:
					t = (this.temp - 273.15);
					this.temp = t;
					break;

				case FAHRENHEIT:
					t= (this.temp -273.15)*9/5+32;
					this.temp = t;
					break;

				case KELVIN: 
					break;
				}

			}

			return this;  // do NOT change this return statement.
		}
		/** setter for temperature
		 *
		 * @param temp is the new temperature (in the object's current scale)
	   * @return a reference to this object.
		 */
		public Temperature setTemp(double temp){
			switch(this.scale)
			{
			case CELSIUS:
				if (temp <= -273.15)
					this.temp = -273.15;
				else
					this.temp = temp;
				break;

			case FAHRENHEIT: 
				if (temp<= -459.67)
					this.temp = -459.67;
				else
					this.temp = temp;
				break;

			case KELVIN:
				if (temp < 0)
					this.temp = 0;
				else
					this.temp = temp;

			}


			return this;  // do NOT change this return statement.
		}
		/** setter for temperature
		 *
		 * @param temp is the new temperature
		 * @param scale is the scale of the new temperature. It must be
		 *        a constant from the Scale enum type.
	   * @return a reference to this object.
	   */
		
		public Temperature setTemp(double temp, Scale scale){
			setScale(scale);
			setTemp(temp);

			return this;  // do NOT change this return statement.
		}

		/** setter for temperature
		 *
		 * @param temp is the new temperature.
		 * @param scale is a string representing one of the three scales.
	   * @return a reference to this object.
	   */
		public Temperature setTemp(double temp, String scale){
			char cscale = scale.charAt(0);
			Scale sc = Scale.CELSIUS;
			switch (cscale)
			{
			case 'C':
				sc = Scale.CELSIUS;
				break;

			case 'F':
				sc = Scale.FAHRENHEIT;
				break;

			case 'K':
				sc = Scale.KELVIN;
				break;
			}

			setScale(sc);
			setTemp(temp);
			return this;  // do NOT change this return statement.
		}
		/* ------------------------------------------------- */
		/* ------------------------------------------------- */
	  /* do not change anything below this                 */
	  /* ------------------------------------------------- */
		/* ------------------------------------------------- */

	  /** String representation of a temperature object    */
		@Override
		public String toString(){
			String temperature = Double.toString(this.getTemp());
			String scale = Character.toString(this.getScale());
			return  temperature + scale;
		}
		public static void main(String[] a){
			// to complete
			Temperature t = new Temperature(10.1);
			System.out.println(t.getScale()); // outputs the char 'C'
			System.out.println(t); // outputs 10.1C
			t.setScale(Scale.FAHRENHEIT);
			System.out.println(t); // outputs 50.18F
			System.out.println(t.getScale()); // outputs the char 'F'
			t.setTemp(12.25, "Kel"); // ***
			System.out.println(t); // outputs 12.25K



		} // end main
	}
