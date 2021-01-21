@Test public void should_delegate_to_assert_comparable() throws Exception {
class IntBox implements Comparable<IntBox> {
    private final Integer number;
    IntBox(    Integer number){
      this.number=number;
    }
    @Override public int compareTo(    IntBox o){
      return number.compareTo(o.number);
    }
  }
  then(new IntBox(1)).isLessThan(new IntBox(2));
}
