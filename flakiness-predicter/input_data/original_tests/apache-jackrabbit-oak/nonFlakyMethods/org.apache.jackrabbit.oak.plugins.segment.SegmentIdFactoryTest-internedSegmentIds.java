@Test public void internedSegmentIds(){
  assertTrue(factory.getSegmentId(0,0) == factory.getSegmentId(0,0));
  assertTrue(factory.getSegmentId(1,2) == factory.getSegmentId(1,2));
  assertTrue(factory.getSegmentId(1,2) != factory.getSegmentId(3,4));
}
