import java.util.Scanner;

public class weatherReportTester {

	public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			System.out.println("Welcome to our Weather Report Station");
			System.out.println("-----------------------------------------------------");
			
			
			System.out.println("Choose one of the following actions:");
			System.out.println("1. Test the TimeStamp class");
			System.out.println("2. Compare two Temperatures");
			System.out.println("3. Test the WeatherReport class");
			System.out.println("4. Exit");
			int choice = input.nextInt();
			
			while (choice != 4)
			{
				if (choice == 1)
				{ //take timestamp from user
					System.out.println("Please enter TimeStamps(hour/day/minute): ");
					int d = input.nextInt();
					int h = input.nextInt();
					int m = input.nextInt();
					TimeStamp ts = new TimeStamp(d, h, m);
					ts.getDay();
					ts.getHour();
					ts.getMinute();
					System.out.println(ts.toString());
					
				}
				else if (choice == 2)
				{
					System.out.println("Please enter two temperatures to compare:");
					double x = input.nextDouble();
					double y = input.nextDouble();
					Temperature X=new Temperature (x);
					Temperature Y=new Temperature (y);
					Compare comp = new Compare();
					System.out.println(comp.compare(X,Y));
				}
				else if (choice == 3)
				{
					System.out.println("Please enter temperature: ");
					double temp = input.nextDouble();
					System.out.println("Please enter TimeStamps(day/hour/minute): ");
					int d = input.nextInt();
					int h = input.nextInt();
					int m = input.nextInt();
					Temperature t1 = new Temperature (temp);
					TimeStamp t2 = new TimeStamp (d, h, m);
					WeatherReport wr = new WeatherReport(t1, t2);
					System.out.println("Temperature: " + wr.getTemperature()+ " TimeStamp: " + wr.getTime());
					System.out.println(wr.toString());
				}
				else
				{
					System.out.println("Please get another choice");
				}
				System.out.println("\nPlease enter your choice:");
				System.out.println("1. Test the TimeStamp class");
				System.out.println("2. Compare two Temperatures");
				System.out.println("3. Test the WeatherReport class");
				System.out.println("4. Exit");
				choice = input.nextInt();
			
			}
			System.out.println("\nThank you for using our weather forecast system");
			}


	}