package za.co.bbd.gradprogram.jigsaw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PuzzleMove {

    private int x1, y1, x2, y2;
}
