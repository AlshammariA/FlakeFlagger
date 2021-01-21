/** 
 * This is a test to make sure properties are properly escaped in merge.
 */
@Test public void oneBranchAddPropertyRoot(){
  String branchRev=mk.branch(null);
  branchRev=setProp(branchRev,"/jcr:primaryType","nam:rep:root");
  assertPropExists(branchRev,"/","jcr:primaryType");
  branchRev=mk.merge(branchRev,"");
  assertPropExists(branchRev,"/","jcr:primaryType");
  String mergedNode=mk.getNodes("/",branchRev,0,0,-1,null);
  String expectedNode="{\"jcr:primaryType\":\"nam:rep:root\",\":childNodeCount\":0}";
  assertEquals("Wrong property value after merge",expectedNode,mergedNode);
}
