@Test public void parse(){
  Revision low=Revision.fromString("r1-0-1");
  Revision high=Revision.fromString("r2-0-1");
  Range r=new Range(high,low,0);
  assertEquals("r1-0-1/0",r.getLowValue());
  assertEquals(r,Range.fromEntry(high,r.getLowValue()));
}
