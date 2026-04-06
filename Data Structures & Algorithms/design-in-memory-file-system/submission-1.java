class FileSystem {
    Map<String,List<String>> directories;
    Map<String,StringBuilder> files;
    public FileSystem() {
        directories=new HashMap<>();
        files=new HashMap<>();
        directories.put("/",new ArrayList<>());
    }
    
    public List<String> ls(String path) {
        List<String> res=new ArrayList<>();
        if(path.equals("/")){
             for(String child:directories.get("/")){
                res.add(child);
            }
            Collections.sort(res,Comparator.naturalOrder());
            return res;
        }
        String[] contents=path.split("[/]");
        System.out.println("path: "+path);
        String guy=contents[contents.length-1];
       
        if(files.containsKey(path)){
            res.add(guy);
            return res;
        }
        if(directories.containsKey(path)){
            for(String child:directories.get(path)){
                res.add(child);
            }
            Collections.sort(res,Comparator.naturalOrder());
            return res;
        }
        return res;
    }
    
    public void mkdir(String path) {
        String[] contents=path.split("[/]");
        String parent="/";
        for(int i=1;i<contents.length;i++){
            List<String> children = directories.get(parent);
            if(!children.contains(contents[i])){
                children.add(contents[i]);
                if(parent=="/")
                    directories.put(parent+contents[i],new ArrayList<>());
                else
                    directories.put(parent+"/"+contents[i],new ArrayList<>());
            }
            
               
                if(parent=="/")
                    parent=parent+contents[i];
                else
                    parent=parent+"/"+contents[i];
            
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] contents=filePath.split("[/]");
        int len=contents.length;
        String fileName=contents[len-1];
        String dirName=contents[len-2];
        if(len-2==0)
            dirName="/"+dirName;
        else{
            int lastIndex=filePath.lastIndexOf("/");
            dirName=filePath.substring(0,lastIndex);
        }
        
        List<String> children=directories.get(dirName);
        if(children.contains(fileName)){
            // append
            files.get(filePath).append(content);
        }
        else{
            // create a file
            children.add(fileName);
            files.put(filePath,new StringBuilder(content));
        }
    }
    
    public String readContentFromFile(String filePath) {
        return files.get(filePath).toString();
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
