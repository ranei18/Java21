IMPORT JAVA.IO.*;

PUBLIC CLASS SOURCEREADER{
    PUBLIC STATIC VOID MAIN(STRING[] ARGS){
        TRY (FILEREADER FILE = NEW FILEREADER("SOURCEREADER.JAVA");
                BUFFEREDREADER BUFF = NEW BUFFEREDREADER(FILE)){
            BOOLEAN EOF = FALSE;
            WHILE(!EOF){
                STRING LINE = BUFF.READLINE();
                IF(LINE == NULL){
                    EOF = TRUE;
                } ELSE {
                    SYSTEM.OUT.PRINTLN(LINE);
                }
            }
            BUFF.CLOSE();
        } CATCH (IOEXCEPTION E){
            SYSTEM.OUT.PRINTLN("ERROR -- " + E.GETMESSAGE());
        }
    }
}