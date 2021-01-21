@Test public void testModifiedTime(){
  assertEquals(10,NodeDocument.getModifiedInSecs(10000));
  assertEquals(10,NodeDocument.getModifiedInSecs(10003));
  assertEquals(10,NodeDocument.getModifiedInSecs(12000));
  assertEquals(15,NodeDocument.getModifiedInSecs(15000));
  assertEquals(15,NodeDocument.getModifiedInSecs(15006));
}
