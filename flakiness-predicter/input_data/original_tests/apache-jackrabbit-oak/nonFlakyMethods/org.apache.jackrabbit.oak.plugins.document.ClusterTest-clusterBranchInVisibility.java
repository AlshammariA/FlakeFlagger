@Test public void clusterBranchInVisibility() throws InterruptedException {
  DocumentMK mk1=createMK(1);
  mk1.commit("/","+\"regular\": {}",null,null);
  String b1=mk1.branch(null);
  String b2=mk1.branch(null);
  b1=mk1.commit("/","+\"branchVisible\": {}",b1,null);
  b2=mk1.commit("/","+\"branchInvisible\": {}",b2,null);
  mk1.merge(b1,null);
  mk1.dispose();
  DocumentMK mk2=createMK(2);
  String nodes=mk2.getNodes("/",null,0,0,100,null);
  assertEquals("{\"branchVisible\":{},\"regular\":{},\":childNodeCount\":2}",nodes);
  mk2.dispose();
}
