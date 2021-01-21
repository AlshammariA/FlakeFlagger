@Test public void orderableFolder() throws Exception {
  new TestContentLoader().loadTestContent(getAdminSession());
  doTest("test:orderableFolder");
}
