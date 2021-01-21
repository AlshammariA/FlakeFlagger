@Test public void addRemoveSet() throws Exception {
  for (int i=0; i < MK_COUNT; i++) {
    unseenChanges[i]=new HashSet<Integer>();
    mkList[i]=createMK(i);
    revList[i]=mkList[i].getHeadRevision();
  }
  HashMap<Integer,ClusterRev> revs=new HashMap<Integer,ClusterRev>();
  Random r=new Random(1);
  int operations=1000, nodeCount=10;
  int valueCount=10;
  int maxBackRev=20;
  log=new StringBuilder();
  try {
    int maskOk=0, maskFail=0;
    int opCount=6;
    nodeChange.clear();
    for (int i=0; i < operations; i++) {
      opId=i;
      mkId=r.nextInt(mkList.length);
      String node="t" + r.nextInt(nodeCount);
      String node2="t" + r.nextInt(nodeCount);
      String property="x";
      String value="" + r.nextInt(valueCount);
      String diff;
      int op=r.nextInt(opCount);
      if (i < 20) {
        op=0;
      }
      String result;
      boolean conflictExpected;
switch (op) {
case 0:
        diff="+ \"" + node + "\": { \""+ property+ "\": "+ value+ "}";
      log(diff);
    if (exists(node)) {
      log("already exists");
      result=null;
    }
 else {
      conflictExpected=isConflict(node);
      result=commit(diff,conflictExpected);
      if (result != null) {
        changes.put(i,Arrays.asList(new Op(mkId,node,value)));
        nodeChange.put(node,i);
      }
    }
  break;
case 1:
diff="- \"" + node + "\"";
log(diff);
if (exists(node)) {
conflictExpected=isConflict(node);
result=commit(diff,conflictExpected);
if (result != null) {
changes.put(i,Arrays.asList(new Op(mkId,node,null)));
nodeChange.put(node,i);
}
}
 else {
log("doesn't exist");
result=null;
}
break;
case 2:
diff="^ \"" + node + "/"+ property+ "\": "+ value;
log(diff);
if (exists(node)) {
conflictExpected=isConflict(node);
result=commit(diff,conflictExpected);
if (result != null) {
changes.put(i,Arrays.asList(new Op(mkId,node,value)));
nodeChange.put(node,i);
}
}
 else {
log("doesn't exist");
result=null;
}
break;
case 3:
diff="> \"" + node + "\": \""+ node2+ "\"";
log(diff);
if (exists(node) && !exists(node2)) {
conflictExpected=isConflict(node) | isConflict(node2);
result=commit(diff,conflictExpected);
if (result != null) {
value=getValue(mkId,i,node);
changes.put(i,Arrays.asList(new Op(mkId,node,null),new Op(mkId,node2,value)));
nodeChange.put(node,i);
nodeChange.put(node2,i);
}
}
 else {
log("source doesn't exist or target exists");
result=null;
}
break;
case 4:
if (isConflict(node)) {
result=null;
}
 else {
diff="* \"" + node + "\": \""+ node2+ "\"";
log(diff);
if (exists(node) && !exists(node2)) {
conflictExpected=isConflict(node2);
result=commit(diff,conflictExpected);
if (result != null) {
value=getValue(mkId,i,node);
changes.put(i,Arrays.asList(new Op(mkId,node2,value)));
nodeChange.put(node2,i);
}
}
 else {
log("source doesn't exist or target exists");
result=null;
}
}
break;
case 5:
log("sync/refresh");
syncAndRefreshAllClusterNodes();
result=revList[mkId]=mkList[mkId].getHeadRevision();
maskFail|=1 << op;
break;
default :
fail();
result=null;
}
if (result == null) {
maskFail|=1 << op;
log(" -> fail " + Integer.toBinaryString(maskFail));
}
 else {
maskOk|=1 << op;
log(" -> " + result);
for (int j=0; j < unseenChanges.length; j++) {
if (j != mkId) {
unseenChanges[j].add(i);
}
}
}
log("get " + node);
boolean x=get(i,node);
log("get " + node + " returns "+ x);
log("get " + node2);
x=get(i,node2);
log("get " + node2 + " returns "+ x);
DocumentMK mk=mkList[mkId];
ClusterRev cr=new ClusterRev();
cr.mkId=mkId;
cr.rev=mk.getHeadRevision();
revs.put(i,cr);
revs.remove(i - maxBackRev);
log.append('\n');
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
for (int i=0; i < MK_COUNT; i++) {
mkList[i].dispose();
}
}
