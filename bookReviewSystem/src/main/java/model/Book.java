package model;

//provides getter,setter,constructor and toString methods
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data

//required data members of book class
public class Book {

	private int bid;
	private String bname;
	private int price;
	private String publisher;
	
	
}
