private void addRemoveSetMoveCopy(boolean branchMerge) throws Exception {
  ns=createNodeStore();
  mk=new NodeStoreKernel(ns);
  mkGold=new NodeStoreKernel(new SegmentNodeStore());
  HashMap<Integer,String> revsGold=new HashMap<Integer,String>();
  HashMap<Integer,String> revs=new HashMap<Integer,String>();
  Random r=new Random(1);
  int operations=1000, nodeCount=10;
  int propertyCount=5, valueCount=10;
  int maxBackRev=20;
  log=new StringBuilder();
  try {
    int maskOk=0, maskFail=0;
    int opCount=5;
    if (branchMerge) {
      opCount=7;
    }
    for (int i=0; i < operations; i++) {
      String node="t" + r.nextInt(nodeCount);
      String node2="t" + r.nextInt(nodeCount);
      String property="p" + r.nextInt(propertyCount);
      String value="" + r.nextInt(valueCount);
      String diff;
      int op=r.nextInt(opCount);
      boolean result;
switch (op) {
case 0:
        diff="+ \"" + node + "\": { \""+ property+ "\": "+ value+ "}";
      log(diff);
    result=commit(diff);
  break;
case 1:
diff="- \"" + node + "\"";
log(diff);
result=commit(diff);
break;
case 2:
diff="^ \"" + node + "/"+ property+ "\": "+ value;
log(diff);
result=commit(diff);
break;
case 3:
diff="> \"" + node + "\": \""+ node2+ "\"";
log(diff);
result=commit(diff);
break;
case 4:
diff="* \"" + node + "\": \""+ node2+ "\"";
log(diff);
result=commit(diff);
break;
case 5:
if (!branchMerge) {
fail();
}
if (commitRevGold == null) {
log("branch");
commitRevGold=mkGold.branch(commitRevGold);
commitRev=mk.branch(commitRev);
result=true;
}
 else {
result=false;
}
break;
case 6:
if (!branchMerge) {
fail();
}
if (commitRevGold != null) {
log("merge");
mkGold.merge(commitRevGold,null);
mk.merge(commitRev,null);
commitRevGold=null;
commitRev=null;
result=true;
}
 else {
result=false;
}
break;
default :
fail();
result=false;
}
if (result) {
maskOk|=1 << op;
}
 else {
maskFail|=1 << op;
}
get(node);
get(node2);
String revGold=mkGold.getHeadRevision();
String rev=mk.getHeadRevision();
revsGold.put(i,revGold);
revs.put(i,rev);
revsGold.remove(i - maxBackRev);
revs.remove(i - maxBackRev);
int revId=i - r.nextInt(maxBackRev);
revGold=revsGold.get(revId);
if (revGold != null) {
rev=revs.get(revId);
get(node,revGold,rev);
}
}
if (Integer.bitCount(maskOk) != opCount) {
fail("Not all operations were at least once successful: " + Integer.toBinaryString(maskOk));
}
if (Integer.bitCount(maskFail) != opCount) {
fail("Not all operations failed at least once: " + Integer.toBinaryString(maskFail));
}
}
 catch (AssertionError e) {
throw new Exception("log: " + log,e);
}
catch (Exception e) {
throw new Exception("log: " + log,e);
}
ns.dispose();
}
