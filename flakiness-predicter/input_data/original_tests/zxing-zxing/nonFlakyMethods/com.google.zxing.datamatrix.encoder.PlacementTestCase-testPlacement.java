@Test public void testPlacement(){
  String codewords=unvisualize("66 74 78 66 74 78 129 56 35 102 192 96 226 100 156 1 107 221");
  DebugPlacement placement=new DebugPlacement(codewords,12,12);
  placement.place();
  String[] expected={"011100001111","001010101000","010001010100","001010100010","000111000100","011000010100","000100001101","011000010000","001100001101","100010010111","011101011010","001011001010"};
  String[] actual=placement.toBitFieldStringArray();
  for (int i=0; i < actual.length; i++) {
    assertEquals("Row " + i,expected[i],actual[i]);
  }
}
