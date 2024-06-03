import { StyleSheet } from "react-native";

const styles = StyleSheet.create({

    botao: {
        marginLeft: 20,
        marginTop: 40,
        padding: 10,
        backgroundColor: '#392DE9',
        borderRadius: 8,
    },
    Tela: {
        alignItems: 'flex-start',
    },
    Tela1: {
        flex: 1,
        backgroundColor: "#FFFFFF",
    },

    Divdecima: {
        marginTop: 30,
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'space-between',

    },
    imgdePerfil: {
        width: 140,
        height: 100,
        display: 'flex',
        justifyContent: 'center',
        margin: 10,
        marginRight: 10,
        backgroundColor: "#ECECEC",
        borderRadius: 18,
        alignItems: 'center'
    },
    nomeIdade: {
        justifyContent: 'center',
        padding: 10,
        backgroundColor: "#ECECEC",
        width: 230,
        height: 100,
        margin: 10,
        borderRadius: 18,
    },
    DivdoMeio: {

        margin: 10,
        padding: 10,
        justifyContent: 'center',
        borderRadius: 18,
        marginLeft: 20,
        width: 370,
        height: 100,
        backgroundColor: '#392DE9'

    },
    textMeio: {
        color: 'white'
    },
    DivdeBaixo: {
        backgroundColor: "#ECECEC",
        width: 370,
        height: 200,
        margin: 10,
        marginLeft: 20,
        borderRadius: 18,
        padding: 10,
    },

    divconteiner: {

        display: 'flex',
        alignItems: 'center',
    }


});

export default styles;