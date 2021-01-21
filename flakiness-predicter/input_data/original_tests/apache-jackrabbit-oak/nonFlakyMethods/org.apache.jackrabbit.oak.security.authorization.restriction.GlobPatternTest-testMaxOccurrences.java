@Test public void testMaxOccurrences(){
  GlobPattern gp=GlobPattern.create("/","1*/2*/3*/4*/5*/6*/7*/8*/9*/10*/11*/12*/13*/14*/15*/16*/17*/18*/19*/20*/21*");
  try {
    gp.matches("/1/2/3/4/5/6/7/8/9/10/11/12/13/14/15/16/17/18/19/20/21");
    fail();
  }
 catch (  IllegalArgumentException e) {
  }
  ;
  try {
    gp.matches("/11/22/33/44/55/66/77/88/99/100/111/122/133/144/155/166/177/188/199/200/211");
    fail();
  }
 catch (  IllegalArgumentException e) {
  }
  ;
}
