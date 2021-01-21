/** 
 * Just write multiple logs then split.  Before fix for HADOOP-2283, this would fail.
 * @throws IOException
 */
public void testSplit() throws IOException {
  final byte[] tableName=Bytes.toBytes(getName());
  final byte[] rowName=tableName;
  HLog log=new HLog(this.fs,this.dir,this.oldLogDir,this.conf,null);
  final int howmany=3;
  HRegionInfo[] infos=new HRegionInfo[3];
  for (int i=0; i < howmany; i++) {
    infos[i]=new HRegionInfo(new HTableDescriptor(tableName),Bytes.toBytes("" + i),Bytes.toBytes("" + (i + 1)),false);
  }
  try {
    for (int ii=0; ii < howmany; ii++) {
      for (int i=0; i < howmany; i++) {
        for (int j=0; j < howmany; j++) {
          WALEdit edit=new WALEdit();
          byte[] family=Bytes.toBytes("column");
          byte[] qualifier=Bytes.toBytes(Integer.toString(j));
          byte[] column=Bytes.toBytes("column:" + Integer.toString(j));
          edit.add(new KeyValue(rowName,family,qualifier,System.currentTimeMillis(),column));
          System.out.println("Region " + i + ": "+ edit);
          log.append(infos[i],tableName,edit,System.currentTimeMillis());
        }
      }
      log.hflush();
      log.rollWriter();
    }
    List<Path> splits=HLog.splitLog(this.testDir,this.dir,this.oldLogDir,this.fs,this.conf);
    verifySplits(splits,howmany);
    log=null;
  }
  finally {
    if (log != null) {
      log.closeAndDelete();
    }
  }
}
