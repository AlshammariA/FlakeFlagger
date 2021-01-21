@Test public void idCompareToEqualsTest(){
  final Id id1=Id.fromString("00000000000002cc");
  final Id id2=Id.fromString("00000000000002cc");
  assertTrue(id1 + " should be equals to " + id2,id1.compareTo(id2) == 0);
}
