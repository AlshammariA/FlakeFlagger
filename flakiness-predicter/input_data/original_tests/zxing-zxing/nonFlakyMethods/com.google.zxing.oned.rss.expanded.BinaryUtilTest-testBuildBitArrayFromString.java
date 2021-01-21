@Test public void testBuildBitArrayFromString(){
  CharSequence data=" ..X..X.. ..XXX... XXXXXXXX ........";
  check(data);
  data=" XXX..X..";
  check(data);
  data=" XX";
  check(data);
  data=" ....XX.. ..XX";
  check(data);
  data=" ....XX.. ..XX..XX ....X.X. ........";
  check(data);
}
