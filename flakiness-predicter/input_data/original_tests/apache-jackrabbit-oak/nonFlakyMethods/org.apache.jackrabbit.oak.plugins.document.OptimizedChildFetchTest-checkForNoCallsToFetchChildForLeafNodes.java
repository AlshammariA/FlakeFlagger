@Test public void checkForNoCallsToFetchChildForLeafNodes(){
  String head=mk.getHeadRevision();
  String rev=mk.commit("","+\"/root\":{}\n" + "+\"/root/a\":{}\n" + "+\"/root/c\":{}\n"+ "+\"/root/a/b\":{}\n",head,"");
  ds.paths.clear();
  resetMK();
  mk.getNodes("/root/a",rev,0,0,10,null);
  assertThat(ds.paths,hasItem("3:/root/a/"));
  resetMK();
  ds.paths.clear();
  assertNotNull(mk.getNodes("/root/c",rev,0,0,10,null));
  assertNotNull(mk.getNodes("/root/a/b",rev,0,0,10,null));
  assertTrue(ds.paths.isEmpty());
}
