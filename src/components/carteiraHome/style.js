import { StyleSheet } from "react-native";

const styles = StyleSheet.create({

    formContext: {
        width:"100%",
        height:"100%",
        bottom:0,
        backgroundColor:"#C0C0C0",
        alignItems: "center",
        borderTopLeftRadius:30,
        borderTopRightRadius:30,
        marginTop:30,
    },
    form:{
        width:"100%",
        height:"auto",
        marginTop:30,
        padding:10
    },
    textButtonAcessar:{
        fontSize:22,
        color:"#FFFFFF"
    },
    buttonAcessar:{
        borderRadius:50,
        alignItems:"center",
        justifyContent:"center",
        width:"90%",
        backgroundColor:"#392DE9",
        paddingTop:10,
        paddingBottom:10,
        marginLeft:12,
        margin:30,
       
    },
    textTitle: {
        color: "#1C1C1C",
        fontSize: 36,
        fontWeight: "bold",
        paddingTop:100,
        marginLeft:20
    }

    

});

export default styles;