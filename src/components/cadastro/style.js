import { StyleSheet, TextInput } from "react-native";

const styles = StyleSheet.create({

    formContext: {
        width: "100%",
        height: "100%",
        bottom: 0,
        backgroundColor: "#C0C0C0",
        alignItems: "center",
        borderTopLeftRadius: 30,
        borderTopRightRadius: 30,
        marginTop: 30,
    },
    form: {
        width: "100%",
        height: "auto",
        marginTop: 30,
        padding: 10
    },
    textButtonAcessar: {
        fontSize: 22,
        color: "#FFFFFF"
    },
    buttonAcessar1: {
        borderRadius: 10,
        alignItems: "center",
        width: "40%",
        backgroundColor: "#1C44D0",
        paddingTop: 10,
        paddingBottom: 10,
        margin: 10,
        marginTop: 30,
        alignItems: 'center',
        height: 50,

    },
    buttonAcessar2: {
        borderRadius: 10,
        alignItems: "center",
        width: "40%",
        backgroundColor: "#1C44D0",
        paddingTop: 10,
        paddingBottom: 10,
        margin: 10,
        marginTop: 30,
        alignItems: 'center',
        height: 50,
    },
    div: {
        flexDirection: 'row',
        justifyContent: 'space-between',

    },
    textTitle: {
        marginTop: 40,
        padding: 10,
        marginBottom: 20,
        color: "dodgerblue",
        fontSize: 36,
        fontWeight: "bold",
        paddingTop: 10,
        marginLeft: 0,

    },

    textinput: {
        borderWidth: 5,
        borderColor: 'dodgerblue',
        backgroundColor: '#ECECEC',
        padding: 17,
        width: 390,
        margin: 10,
        borderRadius: 5,
        alignItems: 'center',
    },

    img: {
        marginRight: 20,
        marginLeft: 10,
        marginTop: 30,
        width: 200,
        height: 100,
    },
    txt: {
        marginLeft: 10,
        color: "dodgerblue",
    },

    topo: {

        display: 'flex',
        justifyContent: 'space-between',
        flexDirection: 'row-reverse'
    },
    

    
    
        botao:{
            width: 60,
            marginLeft:20,
            marginTop:40,
            padding:10,
            backgroundColor:'#1C44D0',
            borderRadius:8,
    }

});
export default styles;