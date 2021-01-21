@Test public void testCompleteDecode() throws Exception {
  OneDReader rssExpandedReader=new RSSExpandedReader();
  BinaryBitmap binaryMap=TestCaseUtil.getBinaryBitmap("test/data/blackbox/rssexpandedstacked-2/1000.png");
  Result result=rssExpandedReader.decode(binaryMap);
  assertEquals("(01)98898765432106(3202)012345(15)991231",result.getText());
}
