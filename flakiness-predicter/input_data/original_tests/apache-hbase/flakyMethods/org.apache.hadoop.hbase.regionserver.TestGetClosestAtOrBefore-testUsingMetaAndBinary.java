public void testUsingMetaAndBinary() throws IOException {
  FileSystem filesystem=FileSystem.get(conf);
  Path rootdir=filesystem.makeQualified(new Path(conf.get(HConstants.HBASE_DIR)));
  filesystem.mkdirs(rootdir);
  HRegionInfo.FIRST_META_REGIONINFO.getTableDesc().setMemStoreFlushSize(64 * 1024 * 1024);
  HRegion mr=HRegion.createHRegion(HRegionInfo.FIRST_META_REGIONINFO,rootdir,this.conf);
  for (char c='A'; c < 'D'; c++) {
    HTableDescriptor htd=new HTableDescriptor("" + c);
    final int last=128;
    final int interval=2;
    for (int i=0; i <= last; i+=interval) {
      HRegionInfo hri=new HRegionInfo(htd,i == 0 ? HConstants.EMPTY_BYTE_ARRAY : Bytes.toBytes((byte)i),i == last ? HConstants.EMPTY_BYTE_ARRAY : Bytes.toBytes((byte)i + interval));
      Put put=new Put(hri.getRegionName());
      put.add(CATALOG_FAMILY,REGIONINFO_QUALIFIER,Writables.getBytes(hri));
      mr.put(put,false);
    }
  }
  InternalScanner s=mr.getScanner(new Scan());
  try {
    List<KeyValue> keys=new ArrayList<KeyValue>();
    while (s.next(keys)) {
      LOG.info(keys);
      keys.clear();
    }
  }
  finally {
    s.close();
  }
  findRow(mr,'C',44,44);
  findRow(mr,'C',45,44);
  findRow(mr,'C',46,46);
  findRow(mr,'C',43,42);
  mr.flushcache();
  findRow(mr,'C',44,44);
  findRow(mr,'C',45,44);
  findRow(mr,'C',46,46);
  findRow(mr,'C',43,42);
  byte[] firstRowInC=HRegionInfo.createRegionName(Bytes.toBytes("" + 'C'),HConstants.EMPTY_BYTE_ARRAY,HConstants.ZEROES);
  Scan scan=new Scan(firstRowInC);
  s=mr.getScanner(scan);
  try {
    List<KeyValue> keys=new ArrayList<KeyValue>();
    while (s.next(keys)) {
      mr.delete(new Delete(keys.get(0).getRow()),null,false);
      keys.clear();
    }
  }
  finally {
    s.close();
  }
  findRow(mr,'C',44,-1);
  findRow(mr,'C',45,-1);
  findRow(mr,'C',46,-1);
  findRow(mr,'C',43,-1);
  mr.flushcache();
  findRow(mr,'C',44,-1);
  findRow(mr,'C',45,-1);
  findRow(mr,'C',46,-1);
  findRow(mr,'C',43,-1);
}
