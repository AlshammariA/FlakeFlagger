@Test public void idCompareToGreaterThanOneDigitTest(){
  final Id id1=Id.fromString("0000000000000007");
  final Id id2=Id.fromString("000000000000000c");
  assertTrue(id1 + " should be less than " + id2,id1.compareTo(id2) < 0);
}
