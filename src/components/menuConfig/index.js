import { useContext, useEffect, useState } from "react";
import { View, Text, TouchableOpacity, Image } from "react-native";
import { useNavigation } from "@react-navigation/native";
import styles from "./style";
import { AuthContext } from "../../context/auth";
import blogFetch from "../../axios/config";

export default function Info() {
    const navigation = useNavigation();
    const { idToken, logOut } = useContext(AuthContext);
    const [email, setEmail] = useState();
    const [telefone, setTelefone] = useState();
    const [loading, setLoading] = useState(true);

    async function getDados(){
        try {
            const response = await blogFetch.get(`conta/${idToken}`);
            const { email, telefone } = response.data;
            setEmail(email);
            setTelefone(telefone);
            setLoading(false);
        } catch (error) {
            console.log(error);//pode apagar
            setLoading(false);
        }
    }

    useEffect(() => {
        getDados();
    }, []);

    const infoUser = () => (
        <View style={styles.TelaUser}>      
            <Text style={styles.TextUser}>Email: {email} </Text>
            <Text style={styles.TextUser}>Telefone: {telefone} </Text>
            <Text style={styles.TextUser}>Trocar senha</Text>
        </View>
    );
   
    return(
    <View style={styles.Tela1}>
        <View style={styles.Tela}> 

    <View style={styles.Tela}>
        <Text style={styles.Text}>Informações da conta</Text>

    <View>
                {loading ? (
                    <Text>Procurando informações da conta</Text>
                ) : (
                    infoUser()
                )}
            </View>
    

    <TouchableOpacity onPress={() => logOut()} style={styles.botao2}>
    <Text style={styles.Text2}>Logout</Text>
    </TouchableOpacity>
    </View>
    </View>
    </View>
    )
}
