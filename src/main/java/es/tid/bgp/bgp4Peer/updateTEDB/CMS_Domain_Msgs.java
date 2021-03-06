package es.tid.bgp.bgp4Peer.updateTEDB;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.LinkedList;

/**
 * Created by Ajmal on 2017-09-27.
 */
public class CMS_Domain_Msgs {

    int DomainID;
    String Entrypoint;
    String learntfrom;
    Boolean Msg_flag= false;
    private Logger log;


    public CMS_Domain_Msgs(LinkedList<CMS_Domain_Msgs> CMS_Msg, String controllerIT, int nodeId, String Learntfrom)
    {
    this.DomainID=nodeId;
    this.Entrypoint= controllerIT;
    this.learntfrom= Learntfrom;




        log= LoggerFactory.getLogger("BGP4Peer");

        if(CMS_Msg.size()==0)
        {
            CMS_Msg.add(new CMS_Domain_Msgs(Entrypoint,DomainID,learntfrom));
        }
    else
        {

            if(!CMS_Msg.contains(new CMS_Domain_Msgs(Entrypoint,DomainID, learntfrom)))
                CMS_Msg.add(new CMS_Domain_Msgs(Entrypoint,DomainID, learntfrom));
        }
    }

    public CMS_Domain_Msgs(String controllerIT, int nodeId, String Learntfrom){

        this.DomainID=nodeId;
        this.Entrypoint= controllerIT;
        this.learntfrom= Learntfrom;
    }


    public boolean equals (Object o) {


        if (o == this)
            return true;
        if (!(o instanceof CMS_Domain_Msgs)) {

            return false;
        }
        CMS_Domain_Msgs cms_domain_msg = (CMS_Domain_Msgs) o;

        return new EqualsBuilder().append(Entrypoint, cms_domain_msg .Entrypoint).append(DomainID, cms_domain_msg .DomainID).append(learntfrom, cms_domain_msg .learntfrom).isEquals();

    }

    public String toString()
    {
        String ret= "Entry Point: "+this.Entrypoint +"<--->" +"Domain ID: " +this.DomainID +"<--->" +"Learnt From: " +this.learntfrom;
        return ret;
    }


    public String getEntryPoint(){

        return this.Entrypoint;
    }


    public int getDomainID(){

        return this.DomainID;
    }


    public void setMsg_Flag(Boolean Msg_flag)

    {
      this.Msg_flag= Msg_flag;

    }

    public String getlearntfrom ()
    {

        return this.learntfrom;
    }

    public boolean getMsg_Flag()
    {
        return this.Msg_flag;
    }

}
