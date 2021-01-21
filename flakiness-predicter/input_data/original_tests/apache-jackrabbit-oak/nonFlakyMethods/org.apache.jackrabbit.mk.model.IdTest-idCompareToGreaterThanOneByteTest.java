@Test public void idCompareToGreaterThanOneByteTest(){
  final Id id1=Id.fromString("0000000000000070");
  final Id id2=Id.fromString("00000000000000c0");
  assertTrue(id1 + " should be less than " + id2,id1.compareTo(id2) < 0);
}
