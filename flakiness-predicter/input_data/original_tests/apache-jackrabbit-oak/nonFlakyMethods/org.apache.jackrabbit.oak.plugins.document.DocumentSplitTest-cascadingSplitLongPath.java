@Test public void cascadingSplitLongPath(){
  String p="/";
  while (!Utils.isLongPath(p)) {
    p=PathUtils.concat(p,"long-path-element");
  }
  cascadingSplit(p);
}
