@Test public void executeMultipleTimesDoesntThrowOutOfMemoryException(){
  final LessCss lessCss=new LessCss();
  for (int i=0; i < 100; i++) {
    lessCss.less("#id {.class {color: red;}}");
  }
}
