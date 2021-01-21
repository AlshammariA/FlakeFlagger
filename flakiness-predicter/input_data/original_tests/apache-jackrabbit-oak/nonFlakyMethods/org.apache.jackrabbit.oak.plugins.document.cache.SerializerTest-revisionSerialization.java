@Test public void revisionSerialization(){
  Revision r=new Revision(System.currentTimeMillis(),1,5);
  assertEquals(r,deserialize(r));
  r=new Revision(System.currentTimeMillis(),1,5,true);
  assertEquals(r,deserialize(r));
}
