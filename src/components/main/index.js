import React, { useState} from "react";
import { View, Text, TouchableOpacity} from "react-native";

import { useNavigation } from "@react-navigation/native";

import styles from './style';

export default function Main(){
    //função usada em botões para trocar de tela
    const navigation = useNavigation();
    //const [textButton, setTextButton] = useState("Acessar");


    return(
        <View>
            <View>
                <Text style={styles.textTitle}>pagina do login</Text>
                    <TouchableOpacity
                    style={styles.buttonAcessar}
                    onPress={() => navigation.navigate("Home")}
                    >
                        <Text style={styles.textButtonAcessar}>Entrar - Pagina HOME</Text>
                    </TouchableOpacity>

                    <TouchableOpacity
                    style={styles.buttonAcessar}
                    onPress={() => navigation.navigate("Cadastro")}
                    >
                        <Text style={styles.textButtonAcessar}>Cadastre-se - Pagina Cadastro</Text>
                    </TouchableOpacity>

                    <TouchableOpacity
                    style={styles.buttonAcessar}
                    onPress={() => navigation.navigate("RecuperarConta")}
                    >
                        <Text style={styles.textButtonAcessar}>Esqueci senha - Pagina RecuperarConta</Text>
                    </TouchableOpacity>
            </View>
        </View>
        
    )


}