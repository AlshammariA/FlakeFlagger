@Test public void testBuildBitArray1(){
  int[][] pairValues={{19},{673,16}};
  String expected=" .......X ..XX..X. X.X....X .......X ....";
  checkBinary(pairValues,expected);
}
