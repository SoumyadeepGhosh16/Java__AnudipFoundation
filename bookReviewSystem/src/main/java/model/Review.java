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

//required data members of Review class
public class Review {

	private int bid;
	private String bname;
	private String remarks;
	private int rating;
}
