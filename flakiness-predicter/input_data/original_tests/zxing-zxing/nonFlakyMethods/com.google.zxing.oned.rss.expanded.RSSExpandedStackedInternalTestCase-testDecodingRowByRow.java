@Test public void testDecodingRowByRow() throws Exception {
  RSSExpandedReader rssExpandedReader=new RSSExpandedReader();
  BinaryBitmap binaryMap=TestCaseUtil.getBinaryBitmap("test/data/blackbox/rssexpandedstacked-2/1000.png");
  int firstRowNumber=binaryMap.getHeight() / 3;
  BitArray firstRow=binaryMap.getBlackRow(firstRowNumber,null);
  try {
    rssExpandedReader.decodeRow2pairs(firstRowNumber,firstRow);
    fail(NotFoundException.class.getName() + " expected");
  }
 catch (  NotFoundException nfe) {
  }
  assertEquals(1,rssExpandedReader.getRows().size());
  ExpandedRow firstExpandedRow=rssExpandedReader.getRows().get(0);
  assertEquals(firstRowNumber,firstExpandedRow.getRowNumber());
  assertEquals(2,firstExpandedRow.getPairs().size());
  firstExpandedRow.getPairs().get(1).getFinderPattern().getStartEnd()[1]=0;
  int secondRowNumber=2 * binaryMap.getHeight() / 3;
  BitArray secondRow=binaryMap.getBlackRow(secondRowNumber,null);
  secondRow.reverse();
  List<ExpandedPair> totalPairs=rssExpandedReader.decodeRow2pairs(secondRowNumber,secondRow);
  Result result=RSSExpandedReader.constructResult(totalPairs);
  assertEquals("(01)98898765432106(3202)012345(15)991231",result.getText());
}
