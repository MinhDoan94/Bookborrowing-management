package constant;

public enum Type_Reader {
    SINH_VIEN("Sinh viên"),
    HOC_VIEN_CAO_HOC("Học viên cao học"),
    GIAO_VIEN("Giáo viên");
    public String value;

    Type_Reader(String value) {
        this.value = value;
    }
}
