@Test public void testGenerateModeMessage(){
  testModeMessage(true,2,29,".X .XXX.. ...X XX.. ..X .XX. .XX.X");
  testModeMessage(true,4,64,"XX XXXXXX .X.. ...X ..XX .X.. XX..");
  testModeMessage(false,21,660,"X.X.. .X.X..X..XX .XXX ..X.. .XXX. .X... ..XXX");
  testModeMessage(false,32,4096,"XXXXX XXXXXXXXXXX X.X. ..... XXX.X ..X.. X.XXX");
}
