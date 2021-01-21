@Test public void testBlob() throws CommitFailedException, IOException {
  Blob expected=new StringBasedBlob("test blob");
  root.getTree("/x").setProperty("blob",expected);
  root.commit();
  Blob actual=root.getTree("/x").getProperty("blob").getValue(Type.BINARY);
  assertEquals(expected,actual);
  assertTrue(expected.getNewStream().available() >= 0);
  assertTrue(actual.getNewStream().available() >= 0);
}
