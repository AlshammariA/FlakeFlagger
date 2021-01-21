@Test public void testBuildBitArrayFromStringWithoutSpaces(){
  CharSequence data=" ..X..X.. ..XXX... XXXXXXXX ........";
  checkWithoutSpaces(data);
  data=" XXX..X..";
  checkWithoutSpaces(data);
  data=" XX";
  checkWithoutSpaces(data);
  data=" ....XX.. ..XX";
  checkWithoutSpaces(data);
  data=" ....XX.. ..XX..XX ....X.X. ........";
  checkWithoutSpaces(data);
}
