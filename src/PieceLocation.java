public class PieceLocation {
    private int row, col;

    public PieceLocation(int newRow, int newCol){
        row = newRow;
        col = newCol;
    }

    //sets row and col to given location
    public void setLocation(PieceLocation location){
        row = location.getRow();
        col = location.getCol();
    }

    //returns row
    public int getRow(){
        return row;
    }

    //returns col
    public int getCol(){
        return col;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) {
            return false;
        }
        if (!PieceLocation.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        PieceLocation pieceLocation = (PieceLocation) obj;
        return (pieceLocation.getRow() == this.row && pieceLocation.getCol() == this.col);
    }
}
