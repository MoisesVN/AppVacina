import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
    principal:{
        width: "100%",
        height: "100%",
        backgroundColor: "#FFFFFF",
        alignItems: "center",
        position: "relative"
    },
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
    divInfo: {
        width: 370,
        height: 260,
        backgroundColor: "#FFFFFF",
        alignItems: "center",
        borderRadius: 18,
        borderWidth: 4,
        borderColor: "#1E90FF",
        display: "flex",
        flexDirection: "column",
        padding: 7
    },
    divTopo: {
        width: "100%",
        height: "60%",
        backgroundColor: "#FFFFFF",
        display: "flex",
        flexDirection: "row",
        alignItems: "center",
        borderRadius: 10,
        
        gap: 14
    },
    divImg: {
        marginBottom: 10,
        width: "35%",
        height: "90%",
        backgroundColor: "#ECECEC"
    },
    divDados: {
        marginBottom: 10,
        width: "61%",
        height: "90%",
        backgroundColor: "#ECECEC"
    },
    divBaixo: {
        width: "100%",
        height: "40%",
        backgroundColor: "#FFFFFF",
        borderRadius: 10,
    },
    proxVacina: {
        width: "100%",
        height: "100%",
        backgroundColor : "#ECECEC",
    },
    form: {
        width: "100%",
        height: "auto",
        marginTop: 30,
        padding: 10,
    },
    textButtonAcessar: {
        fontSize: 22,
        color: "#FFFFFF",
    },
    buttonAcessar: {
        borderRadius: 50,
        alignItems: "center",
        justifyContent: "center",
        width: "90%",
        backgroundColor: "#392DE9",
        paddingTop: 10,
        paddingBottom: 10,
        marginLeft: 12,
        margin: 30,
    },
    textTitle: {
        color: "dodgerblue",
        fontSize: 30,
        fontWeight: "bold",
        marginLeft: "8%",
        marginTop: "14%"
    },
    divText: {
        width: "100%",
        height: "18%",
        backgroundColor: "#FFFFFF",
        display: "flex",
        justifyContent: "center",
        flexDirection: "row",
    },
    divButton: {
        width: "20%",
        height: "100%",
        marginTop: "9%",
    },
    textoCarteira: {
        width: "80%",
        height: "100%",
    },
    divCriar: {
        backgroundColor: "#FFFFFF",
        marginTop: "17%"
    },
    botao2: {
        marginBottom: 20,
        borderRadius: 90,
        padding: 30,
        backgroundColor: '#1E90FF'
    },
    botao: {
        marginLeft: "30%"
    }
});

export default styles;
